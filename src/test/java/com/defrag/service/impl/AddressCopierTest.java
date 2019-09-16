package com.defrag.service.impl;

import com.defrag.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddressCopierTest {

    private AddressCopier copier = new AddressCopierImpl();

    @Test
    public void testCopy() {
        Address source = new Address();
        source.setId(1L);
        source.setCountry("Russia");
        source.setRegion("Siberia");
        source.setCity("Novosibirsk");
        source.setStreet("Red avenue");
        source.setHouse("10");
        source.setFlat("8a");

        Address target = new Address();
        copier.copy(source, target);

        assertNull(target.getId());
        assertNull(target.getCreated());
        assertNull(target.getModified());

        assertEquals(source.getCountry(), target.getCountry());
        assertEquals(source.getRegion(), target.getRegion());
        assertEquals(source.getCity(), target.getCity());
        assertEquals(source.getStreet(), target.getStreet());
        assertEquals(source.getHouse(), target.getHouse());
        assertEquals(source.getFlat(), target.getFlat());
    }
}
