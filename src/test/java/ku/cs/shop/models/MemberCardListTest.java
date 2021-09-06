package ku.cs.shop.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MemberCardListTest {
    @Test
    void testAddCard() {
        MemberCardList list = new MemberCardList();
        list.addCard(new MemberCard("A", "084-000-1111"));
        list.addCard(new MemberCard("B", "084-000-2222"));
        list.addCard(new MemberCard("C", "084-000-3333"));
        list.addCard(new MemberCard("D", "084-000-4444"));

        assertEquals(4, list.countCard());
    }

    @Test
    void testAddPurchaseToCardByPhone() {
        MemberCardList list = new MemberCardList();
        list.addCard(new MemberCard("A", "084-000-1111"));
        list.addCard(new MemberCard("B", "084-000-2222"));
        list.addCard(new MemberCard("C", "084-000-3333"));
        list.addCard(new MemberCard("D", "084-000-4444"));
        String phone = "084-000-3333";
        list.addPurchaseByPhone(phone, 150);
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals(150, card.getCumulativePurchase());
    }

    @Test
    void testUseStampByPhone() {
        MemberCardList list = new MemberCardList();
        list.addCard(new MemberCard("A", "084-000-1111", 10));
        list.addCard(new MemberCard("B", "084-000-2222", 20));
        list.addCard(new MemberCard("C", "084-000-3333", 30));
        list.addCard(new MemberCard("D", "084-000-4444", 40));
        String phone = "084-000-3333";
        list.useStampByPhone(phone, 15);
        MemberCard card = list.searchCardByPhone(phone);
        assertEquals(15, card.getStamp());
    }

}