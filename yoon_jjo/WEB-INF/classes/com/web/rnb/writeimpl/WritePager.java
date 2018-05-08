package com.web.rnb.writeimpl;

import org.springframework.stereotype.Service;

@Service
public class WritePager {
    public static final int PAGE_SCALE=10;
    public static final int BLOCK_SCALE=5;
    private int totalColumn;
    private int curPage;//현 페이지
    private int prevPage;//이전 페이지
    private int nextPage;//다음 페이지
    private int firstPage;//전체 페이지수중 처음
    private int lastPage;//전체 페이지수중 마지막
    private int startPage;//현 블록에서 시작페이지번호
    private int endPage;//현 블록에서 마지막페이지 번호
    private int startColumnNo;
    private int endColumnNo;
    public int getTotalColumn() {
        return totalColumn;
    }
    public void setTotalColumn(int totalColumn) {
        this.totalColumn = totalColumn;
    }
    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getFirstPage() {
        return firstPage;
    }
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }
    public int getLastPage() {
        return lastPage;
    }
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }
    public int getStartPage() {
        return startPage;
    }
    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }
    public int getEndPage() {
        return endPage;
    }
    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartColumnNo() {
        return startColumnNo;
    }
    public void setStartColumnNo(int startColumnNo) {
        this.startColumnNo = startColumnNo;
    }
    public int getEndColumnNo() {
        return endColumnNo;
    }
    public void setEndColumnNo(int endColumnNo) {
        this.endColumnNo = endColumnNo;
    }
    public void makePaging(int totalColumn,int curPage){
        this.totalColumn=totalColumn;
        this.curPage=curPage;
        this.firstPage=1;
        this.lastPage=(totalColumn+(PAGE_SCALE-1))/PAGE_SCALE;

        startPage=((curPage-1)/BLOCK_SCALE)*BLOCK_SCALE+1;
        endPage=startPage+5-1;

        if(endPage>lastPage) endPage=lastPage;

        prevPage=curPage-1;
        if(prevPage<firstPage) prevPage=firstPage;
        nextPage=curPage+1;
        if(nextPage>endPage) nextPage=endPage;

        this.startColumnNo=(curPage-1)*PAGE_SCALE+1;
        if(curPage!=lastPage){
            this.endColumnNo=startColumnNo+9;
        }else{
            this.endColumnNo=totalColumn;
        }
    }
}