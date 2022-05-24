package com.example.garageeindopdracht.Models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PartTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Part#Part(String, String)}
     *   <li>{@link Part#setPartName(String)}
     *   <li>{@link Part#setPartPrice(String)}
     *   <li>{@link Part#getPartName()}
     *   <li>{@link Part#getPartPrice()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Part actualPart = new Part("Name", "Price");
        actualPart.setPartName("Part Name");
        actualPart.setPartPrice("Part Price");
        assertEquals("Part Name", actualPart.getPartName());
        assertEquals("Part Price", actualPart.getPartPrice());
    }
}

