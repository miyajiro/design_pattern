public interface Icecream {
    public String getName();

    public String howSweet();
}

public class VanillaIcecream implements Icecream {
    public String getName() {
        return "バニラアイスクリーム";
    }

    public String howSweet() {
        return "バニラ味";
    }
}

public class CashewNutsToppingIcecream implements Icecream {
    private Icecream ice = null;

    public CashewNutsToppingIcecream(Icecream ice) {
        this.ice = ice;
    }

    public String getName() {
        String name = "カシューナッツ";
        name += ice.getName();
        return name;
    }

    public String howSweet() {
        return ice.howSweet();
    }
}