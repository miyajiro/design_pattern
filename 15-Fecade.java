//所蔵本リスト
public class BookList {
    public String searchBook(String bookName) {
        String location = null;
        // 本の名前から探す
        // あればその場所を、なければnullを返す
        return location;
    }
}

// 貸出帳
public class LendingList {
    public boolean check(String bookName) {
        // 貸出帳をチェックする
        // 貸出中ならtrue、そうでなければfalseを返す
        return true;
    }
}

// 図書委員の中村くん
public class Librarian {
    public String searchBook(String bookName) {
        // 本を探す
        BookList bookList = new BookList();
        String location = bookList.searchBook(bookName);
        // 本の場所がnullではない(所蔵してる)とき
        if (location != null) {
            // 貸出中かチェックする
            LendingList lendingList = new LendingList();
            if (lendingList.check(bookName)) {
                // 貸出中のとき
                return "貸出中です";
            } else {
                // 貸出中ではないとき
                return location;
            }
            // 所蔵してないとき
        } else {
            return "その本は所蔵していません";
        }
    }
}

// 山田くん
public class Visitor {
    public static void main(String[] args) {
        // 窓口の中村くんを作る
        Librarian nakamura = new Librarian();
        // 中村くんに昆虫図鑑の場所を聞く
        String location = nakamura.searchBook("昆虫図鑑");
        if (location.equals("貸出中です")) {
            System.out.println("貸出中かよ…");
        } else if (location.equals("その本は所蔵していません")) {
            System.out.println("なんだ、ないのか");
        } else {
            System.out.println("サンキュ！");
        }
    }
}