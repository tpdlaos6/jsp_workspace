package util;

public class BoardPage {
    public static String pagingStr(int totalCount, int pageSize, int blockPage,
            int pageNum, String reqUrl) {
        String pagingStr = "";

        // 단계 3 : 전체 페이지 수 계산
        int totalPages = (int) (Math.ceil(((double) totalCount / pageSize)));

        // 단계 4 : '이전 페이지 블록 바로가기' 출력 
        // pageTemp가 1이면, 즉 첫페이지에서는 if절이 실행이 안되어서, [첫페이지]와 [이전블록]이 뜨지 않음
        // pageTemp가 1이 아니면, 즉 두번째 페이지부터는 if절이 실행 되어서 [첫페이지]와 [이전블록]이 뜨게끔 코딩
        int pageTemp = (((pageNum - 1) / blockPage) * blockPage) + 1;
        if (pageTemp != 1) {
            pagingStr += "<a href='" + reqUrl + "&pageNum=1'>[첫 페이지]</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "&pageNum=" + (pageTemp - 1)
                         + "'>[이전 블록]</a>";
        }

        // 단계 5 : 각 페이지 번호 출력
        int blockCount = 1;
        while (blockCount <= blockPage && pageTemp <= totalPages) {
            if (pageTemp == pageNum) {
                // 현재 페이지는 링크를 걸지 않음
                // 추가로 현재 페이지에 색깔을 넣는다던지 해서 시각적효과를 주는 방법을 통해 구분이 편하게 하는 방법도 있음
                pagingStr += "&nbsp;" + pageTemp + "&nbsp;";
            } else {
                pagingStr += "&nbsp;<a href='" + reqUrl + "&pageNum=" + pageTemp
                             + "'>" + pageTemp + "</a>&nbsp;";
            }
            pageTemp++;
            blockCount++;
        }

        // 단계 6 : '다음 페이지 블록 바로가기' 출력 // reqUrl : 페이지 넘어갔을 때 주소
        if (pageTemp <= totalPages) {
            pagingStr += "<a href='" + reqUrl + "&pageNum=" + pageTemp
                         + "'>[다음 블록]</a>";
            pagingStr += "&nbsp;";
            pagingStr += "<a href='" + reqUrl + "&pageNum=" + totalPages
                         + "'>[마지막 페이지]</a>";
        }

        return pagingStr;
    }
}
