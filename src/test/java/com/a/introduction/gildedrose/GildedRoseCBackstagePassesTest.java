package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseCBackstagePassesTest {
	
	@Test
	public void testUpdateQualityBackstagePasses1() {
		Item item = new Item("Backstage passes to a concert", 15, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a concert",
				app.items[0].name);
		assertEquals(14, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses2() {
		Item item = new Item("Backstage passes to a concert", 7, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a concert",
				app.items[0].name);
		assertEquals(6, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	public void testUpdateQualityBackstagePasses3() {
		Item item = new Item("Backstage passes to a concert", 4, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a concert",
				app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}

}