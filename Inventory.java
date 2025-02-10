import java.util.*;

class Inventory {
    private final Map<Rarity, List<Item>> items = new HashMap<>();

    public void addItem(Item item) {
        Rarity rarity = item.getRarity();
        if (items.get(rarity) == null) {
            List<Item> list = new LinkedList<>();
            list.add(item);
            items.put(rarity, list);
        } else {
            items.get(rarity).add(item);
        }
    }

    public void displayInventory() {
        if (items.isEmpty()) {
            System.out.println("Empty inventory.");
            return;
        }
        System.out.println("Inventory: ");
        for (Map.Entry<Rarity, List<Item>> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " Items :");
            for (Item item : entry.getValue()) {
                System.out.println("\t" + item);
            }
        }
    }

    public void upgradeItem(Item item) {
        Rarity rarity = item.getRarity();
        if (rarity == Rarity.Legendary) {
            System.out.println("Cannot be upgraded, as it is a legendary item.");
            return;
        }

        List<Item> itemList = items.get(rarity);
        List<Integer> sameItemPosition = new ArrayList<>();
        int numberOfTheSameTypeItem = 0;

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).toString().equals(item.toString())) {
                sameItemPosition.add(i);
                numberOfTheSameTypeItem++;
            }
        }

        if (numberOfTheSameTypeItem == 0) {
            System.out.println("Other items are needed for upgrade.");
        } else {
            if ((rarity == Rarity.Epic || rarity == Rarity.Epic1) && itemList.size() >= 2) {
                item.upgrade();
                itemList.remove((int) sameItemPosition.get(sameItemPosition.size() - 1));
                itemList.remove(0);
                Item newItem = new Item(item.getName(), item.getRarity());
                addItem(newItem);
                return;
            } else {
                if (numberOfTheSameTypeItem >= 3) {
                    item.upgrade();
                    itemList.remove((int) sameItemPosition.get(sameItemPosition.size() - 1));
                    itemList.remove((int) sameItemPosition.get(sameItemPosition.size() - 2));
                    itemList.remove((int) sameItemPosition.get(sameItemPosition.size() - 3));
                    Item newItem = new Item(item.getName(), item.getRarity());
                    addItem(newItem);
                    return;
                }
            }
        }
        System.out.println("Not enough items to upgrade " + item.getName());
    }
}
