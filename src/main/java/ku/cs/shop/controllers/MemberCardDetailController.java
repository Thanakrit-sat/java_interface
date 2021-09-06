package ku.cs.shop.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ku.cs.shop.models.MemberCard;
import javafx.scene.control.Label;
import com.github.saacsos.FXRouter;

import java.io.IOException;

public class MemberCardDetailController {

    // controller เชื่อมต่อกับ model เพื่อเก็บข้อมูลและเรียกข้อมูลมาแสดงผลที่ view
    private MemberCard memberCard;
    @FXML private Label nameLabel;
    @FXML private Label phoneLabel;
    @FXML private Label cumulativePurchaseLabel;
    @FXML private Label pointLabel;
    @FXML private TextField purchaseTextField;
    @FXML private TextField pointTextField;

    @FXML
    public void initialize() {
        // initialize จะถูกเรียกให้ทำงานเมื่อมีการ load Controller นี้
        System.out.println("initialize MemberCardDetailController");
//        memberCard = new MemberCard("John Smith", "081-222-8888");
        memberCard = (MemberCard) FXRouter.getData();
        showMemberCardData();

    }

    @FXML
    public void handleAddPurchaseButton(ActionEvent actionEvent) {
        // รับข้อมูลจาก TextField ข้อมูลที่รับเป็น String เสมอ
        String purchaseString = purchaseTextField.getText();
        // แปลงชนิดข้อมูล String เป็น double ด้วย Double.parseDouble()
        double purchase = Double.parseDouble(purchaseString);
        // เรียกการคำนวณต่าง ๆ จาก model
        memberCard.addPurchase(purchase);
        // แสดงผลข้อมูล
        showMemberCardData();
        // clear ช่อง TextField
        purchaseTextField.clear();
    }

    @FXML
    public void handleUsePointButton(ActionEvent actionEvent) {
        String pointString = pointTextField.getText();
        // แปลงชนิดข้อมูล String เป็น int ด้วย Integer.parseInt()
        int point = Integer.parseInt(pointString);
        memberCard.useStamp(point);
        showMemberCardData();
        pointTextField.clear();
    }


    private void showMemberCardData() {
        nameLabel.setText(memberCard.getName());
        phoneLabel.setText(memberCard.getPhone());
        String cumulativePurchase =
                String.format("%.2f", memberCard.getCumulativePurchase());
        cumulativePurchaseLabel.setText(cumulativePurchase);
        String point = "" + memberCard.getStamp();
        pointLabel.setText(point);
    }

    public void handleBackBtn(){
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }

    }


}
