package se.kth.iv1350.pos.view;

import java.util.Date;

class ErrorMessageHandler {

    void showErrorMsg(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(createDate());
        sb.append(", ERROR: ");
        sb.append(e.getMessage());
        System.out.println(sb);
    }

    private String createDate() {
        return new Date().toString();
    }
}
