public class Item {
    private final String name;
    private int upgradeCount;
    private Rarity rarity;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void upgrade() {
        switch(rarity){
            case Rarity.Epic:
                rarity = Rarity.Epic1;
                upgradeCount++;
                break;
            case Rarity.Epic1:
                rarity = Rarity.Epic2;
                upgradeCount++;
                break;
            case Rarity.Epic2:
                rarity = Rarity.Legendary;
                upgradeCount = 0;
                break;
            case Rarity.Legendary:
                throw new IllegalStateException("Cannot be upgraded. It is a legendary item.");
            default:
                Rarity[] arr = Rarity.values();
                rarity = arr[rarity.ordinal()+1];
        }

    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public String toString() {
        boolean isEpic = rarity.toString().contains("Epic");
        if (rarity.toString().substring(0, 4).equals("Epic")){
            return name + ": Rarity - " + rarity + "; Upgrade Count - " + upgradeCount + ".";
        }
        else{
            return name + ": Rarity - " + rarity + ".";
        }
    }
}
