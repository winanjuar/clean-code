package com.a.introduction.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyGildedRoseRefactoredTest {
    private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
    private static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a concert";
    private static final int MAXIMUM_QUALITY = 50;
    private static final int DEFAULT_QUALITY = 3;
    private static final int EXPIRED_SELLIN = -1;
    private static final int NOT_EXPIRED_SELLIN = 15;
    public static final int SELLIN_GREATER_THAN_10 = 15;
    public static final int SELLIN_BETWEEN_5_AND_10 = 7;
    public static final int SELLIN_LESS_THAN_5 = 4;

    @Test
    void unexpiredDefaultItem_qualityDecreasesBy1() {
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    void expiredDefaultItem_qualityDecreasesBy2() {
        GildedRose app = createGildedRoseWithOneItem(DEFAULT_ITEM, EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    void unexpiredAgedBrie_qualityIncreasesBy1() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, NOT_EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    void expiredAgedBrie_qualityIncreasesBy2() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, EXPIRED_SELLIN - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    void unexpiredAgedBrie_qualityDoesNotGoBeyondMaximum() {
        GildedRose app = createGildedRoseWithOneItem(AGED_BRIE, NOT_EXPIRED_SELLIN, MAXIMUM_QUALITY);
        app.updateQuality();
        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELLIN - 1, MAXIMUM_QUALITY);
        assertItem(expected, app.items[0]);
    }

    @Test
    void backStagePassesBeyond10Days_qualityIncreasesBy1() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_GREATER_THAN_10, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELLIN_GREATER_THAN_10 - 1, DEFAULT_QUALITY + 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    void backStageBetween5And10Days_qualityIncreasesBy2() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_BETWEEN_5_AND_10, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELLIN_BETWEEN_5_AND_10 - 1, DEFAULT_QUALITY + 2);
        assertItem(expected, app.items[0]);
    }

    @Test
    void backStageLessThan5Days_qualityIncreasesBy3() {
        GildedRose app = createGildedRoseWithOneItem(BACKSTAGE_PASSES, SELLIN_LESS_THAN_5, DEFAULT_QUALITY);
        app.updateQuality();
        Item expected = new Item(BACKSTAGE_PASSES, SELLIN_LESS_THAN_5 - 1, DEFAULT_QUALITY + 3);
        assertItem(expected, app.items[0]);
    }

    private void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    private GildedRose createGildedRoseWithOneItem(String itemType, int sellin, int quantity) {
        Item item = new Item(itemType, sellin, quantity);
        Item[] items = new Item[] { item };
        return new GildedRose(items);
    }
}
