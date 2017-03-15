package cc.cicadabear.domain.shared.paginated;

import cc.cicadabear.common.config.JConfig;
import cc.cicadabear.common.util.SecurityUtils;
import cc.cicadabear.common.util.ThreadLocalHolder;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shengzhao Li
 */
public class DefaultPaginated<T> implements Paginated<T>, PaginatedList {

    public static final int DEFAULT_PER_PAGE_SIZE = 10;

    protected List<T> list = new ArrayList<T>();
    protected int perPageSize;
    protected int totalSize = 0;
    protected int pageNumber = 1;

    protected String sortName;
    protected PaginatedSort sort;

    protected String sortCriterion;
    private SortOrderEnum sortOrderEnum;
    private String searchId;


    private int aheadCommonMaxNum = 8;//<<1,2,3,4,5,6,7,8,...,100,101>>
    private int backCommonMinNum = 2;
    private int backCommonMaxNum = 8;//<<1,2,...,101,102,103,104,105,106,107,108>>
    private int aheadCommonMinNum = 2;
    private int middleCommonNum = 7;//<<1,2,...,51,52,53,"54",55,56,57,...,99,100>>
    private String first = JConfig.getConfig("paging.banner.first");//<<
    private String firstDisabled = JConfig.getConfig("paging.banner.first.disabled");
    private String last = JConfig.getConfig("paging.banner.last");//>>
    private String lastDisabled = JConfig.getConfig("paging.banner.last.disabled");
    private String ellipsis = JConfig.getConfig("paging.banner.page.ellipsis"); //...
    private String link = JConfig.getConfig("paging.banner.page.link");
    private String selected = JConfig.getConfig("paging.banner.page.selected");
    private String container = JConfig.getConfig("paging.banner.container");

    private int totalPages;

    private String requestPath;

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }


    public DefaultPaginated() {
        this(DEFAULT_PER_PAGE_SIZE);
    }

    public DefaultPaginated(int perPageSize) {
        this.perPageSize = perPageSize;
    }

    @Override
    public List<T> getList() {
        return list;
    }

    public Map<String, Object> queryMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user", SecurityUtils.currentUser());
        map.put("perPageSize", getPerPageSize());
        map.put("startIndex", getStartIndex());
        return map;
    }

    public int getTotalPages() {
        if (totalSize % perPageSize == 0) {
            return totalSize / perPageSize;
        } else {
            return (totalSize / perPageSize) + 1;
        }
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getObjectsPerPage() {
        return perPageSize;
    }

    @Override
    public int getFullListSize() {
        return totalSize;
    }

    @Override
    public String getSortCriterion() {
        return sortCriterion;
    }

    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    @Override
    public SortOrderEnum getSortDirection() {
        return sortOrderEnum;
    }

    @Override
    public String getSearchId() {
        return searchId;
    }

    @Override
    public int getPerPageSize() {
        return perPageSize;
    }

    @Override
    public int getTotalSize() {
        return totalSize;
    }

    @Override
    public String getSortName() {
        return sortName;
    }

    @Override
    public PaginatedSort getSort() {
        return sort;
    }

    public int getStartIndex() {
        return (getPageNumber() - 1) * getPerPageSize();
    }

    @SuppressWarnings("unchecked")
    public <K extends Paginated> K load(PaginatedLoader<T> paginatedLoader) {
        if (this.totalSize == 0) {
            this.totalSize = paginatedLoader.loadTotalSize();
        }
        this.list = paginatedLoader.loadList();
        afterLoad();
        return (K) this;
    }

    public void afterLoad() {
        // Callback after load data.
    }

    public void setPerPageSize(int perPageSize) {
        this.perPageSize = perPageSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPage(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public void setSort(PaginatedSort sort) {
        this.sort = sort;
    }

    public boolean isHasNext() {
        return getStartIndex() + this.perPageSize < totalSize;
    }

    public boolean isHasPrevious() {
        return getStartIndex() != 0;
    }

    public void setSortOrderEnum(SortOrderEnum sortOrderEnum) {
        this.sortOrderEnum = sortOrderEnum;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }


    public String render() {
        totalPages = getTotalPages();
        String renderHtml = "";
        if (totalPages == 1) {
            return renderHtml;
        }


        //<<1,2,3,4,5,6,7,8,9,10>> (1)
        //<<1,2,3,4,5,6,7,8,...,10,11>> (2) 8+2+1 11
//        <<1,2,...,101,102,103,104,105,106,107,108>>
        //<<1,2,...,51,52,53,"54",55,56,57,...,99,100>> (2) 2+7+2+2 13
        //2种基本模式 pattern <10 >10
        renderHtml += getFirstHtml();

        if (totalPages < aheadCommonMaxNum + backCommonMinNum + 1) {
            for (int i = 1; i <= totalPages; i++) {
                if (i == pageNumber) {
                    renderHtml += getSelectedHtml(i);
                    continue;
                }
                renderHtml += getCommonLinkHtml(i);
            }
        } else {
            renderHtml += getLinksHtml();
        }
        renderHtml += getLastHtml();
//        return renderHtml;
        return parseContainerHtml(renderHtml);
    }

    private String getLinksHtml() {
        String linksHtml = "";
        for (int i = 1; i <= totalPages; i++) {
            if (i == pageNumber) {
                linksHtml += getSelectedHtml(i);
                continue;
            }
            //一共15个页面
            //当前1-6的时候 9不用显出来 7的时候 9需要显出来 进入两个省略号的状态
            if (pageNumber <= aheadCommonMaxNum - 2) {
                if (i <= aheadCommonMaxNum || i > totalPages - backCommonMinNum) {
                    linksHtml += getCommonLinkHtml(i);
                } else if (i == aheadCommonMaxNum + 1) {
                    linksHtml += ellipsis;
                }
                // 当前10-15的时候 7不用显出来 9的时候 7需要显出来 进入两个省略号的状态
            } else if (pageNumber > totalPages - backCommonMaxNum + 2) {
                if (i <= aheadCommonMinNum || i > totalPages - backCommonMaxNum) {
                    linksHtml += getCommonLinkHtml(i);
                } else if (i == aheadCommonMinNum + 1) {
                    linksHtml += ellipsis;
                }
            } else {
                //
                if (i <= aheadCommonMinNum || i > totalPages - backCommonMinNum || (i >= (pageNumber - middleCommonNum / 2) && i <= (pageNumber + middleCommonNum / 2))) {
                    linksHtml += getCommonLinkHtml(i);
                } else if (i == aheadCommonMinNum + 1 || i == totalPages - backCommonMinNum - 1) {
                    linksHtml += ellipsis;
                }
            }
        }
        return linksHtml;
    }

    private String getSelectedHtml(int i) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("0", String.valueOf(i));
        StrSubstitutor sub = new StrSubstitutor(values, "{", "}");
        return sub.replace(selected);
    }

    private String getCommonLinkHtml(int i) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("1", getRequestPath() + "?page=" + i);
        values.put("0", String.valueOf(i));
        StrSubstitutor sub = new StrSubstitutor(values, "{", "}");
        return sub.replace(link);
    }

    private String getRequestPath() {
        return requestPath;
    }

    private String getFirstHtml() {
        if (pageNumber > 1) {
            Map<String, String> values = new HashMap<String, String>();
            values.put("0", getRequestPath() + "?page=" + (pageNumber - 1));
            StrSubstitutor sub = new StrSubstitutor(values, "{", "}");
            return sub.replace(first);
        } else {
            return firstDisabled;
        }
    }

    private String getLastHtml() {
        if (pageNumber < totalPages) {
            Map<String, String> values = new HashMap<String, String>();
            values.put("0", getRequestPath() + "?pageNumber=" + (pageNumber + 1));
            StrSubstitutor sub = new StrSubstitutor(values, "{", "}");
            return sub.replace(last);
        } else {
            return lastDisabled;
        }
    }

    private String parseContainerHtml(String content) {
        Map<String, String> values = new HashMap<String, String>();
        values.put("0", content);
        StrSubstitutor sub = new StrSubstitutor(values, "{", "}");
        return sub.replace(container);
    }
}