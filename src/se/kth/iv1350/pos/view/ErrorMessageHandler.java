package se.kth.iv1350.pos.view;

import java.util.Date;

class ErrorMessageHandler {

    void showErrorMsg(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(createDate());
        sb.append(", ERROR: ");
        sb.append(msg);
        System.out.println(sb);
    }

    private String createDate() {
        return new Date().toString();
    }
}
