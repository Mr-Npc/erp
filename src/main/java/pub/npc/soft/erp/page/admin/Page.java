package pub.npc.soft.erp.page.admin;

import org.springframework.stereotype.Component;

@Component
public class Page {
    private int page = 1;//当前页
    private int rows ;//每页数量显示
    private int offset;//对应数据库中的偏移量

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        this.offset = (page-1)*rows;
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
