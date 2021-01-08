package com.Cocktailbar;

import com.Cocktailbar.Exceptions.OutOfStock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StorageTests
{
    private Storage storage;

    @BeforeEach
    public void setup()
    {
        storage = new Storage();
    }

    @Test
    public void canAddGlass_andCheckStock()
    {
        storage.addGlass("Bierglas");
        assertEquals(1, storage.getGlasses().get("Bierglas"));
        assertEquals(1, storage.checkStockGlass("Bierglas"));
    }

    @Test
    public void canAddTwoOfTheSameGlassAndUpdateCount()
    {
        storage.addGlass("Bierglas");
        storage.addGlass("Bierglas");
        assertEquals(2, storage.getGlasses().get("Bierglas"));
    }

    @Test
    public void canRemoveGlass() throws OutOfStock
    {
        storage.addGlass("Bierglas");
        storage.removeGlass("Bierglas");
        assertNull(storage.getGlasses().get("Bierglas"));
    }

    @Test
    public void checkStockGlass_returnsZero_whenNoneExists()
    {
        assertEquals(0, storage.checkStockGlass("Bierglas"));
    }

    @Test
    public void canGetGlass_andReturnEmptyStockAfterwards()
    {
        storage.addGlass("Bierglas");
        storage.getGlass("Bierglas", 1);
        assertEquals(0, storage.checkStockGlass("Bierglas"));
    }

    @Test
    public void canAddAddon_andCheckStock()
    {
        storage.addAddon("Ijsklontjes");
        assertEquals(1, storage.getAddons().get("Ijsklontjes"));
        assertEquals(1, storage.checkStockAddon("Ijsklontjes"));
    }

    @Test
    public void canAddTwoOfTheSameAddonAndUpdateCount()
    {
        var storage = new Storage();
        storage.addAddon("Ijsklontjes");
        storage.addAddon("Ijsklontjes");
        assertEquals(2, storage.getAddons().get("Ijsklontjes"));
    }

    @Test
    public void canRemoveAddon() throws OutOfStock
    {
        storage.addAddon("Ijsklontjes");
        storage.removeAddon("Ijsklontjes");
        assertNull(storage.getAddons().get("Ijsklontjes"));
    }

    @Test
    public void checkStockAddon_returnsZero_whenNoneExists()
    {
        assertEquals(0, storage.checkStockAddon("Ijsklontjes"));
    }

    @Test
    public void canGetAddon_andReturnEmptyStockAfterwards()
    {
        storage.addAddon("Ijsklontjes");
        storage.getAddon("Ijsklontjes", 1);
        assertEquals(0, storage.checkStockAddon("Ijsklontjes"));
    }

    @Test
    public void canAddIngredient_andCheckStock()
    {
        storage.addIngredient("Banaan");
        assertEquals(1, storage.getIngredients().get("Banaan"));
        assertEquals(1, storage.checkStockIngredient("Banaan"));
    }

    @Test
    public void canAddTwoOfTheSameIngredientAndUpdateCount()
    {
        var storage = new Storage();
        storage.addIngredient("Banaan");
        storage.addIngredient("Banaan");
        assertEquals(2, storage.getIngredients().get("Banaan"));
    }

    @Test
    public void canRemoveIngredient() throws OutOfStock
    {
        storage.addIngredient("Banaan");
        storage.removeIngredient("Banaan");
        assertNull(storage.getIngredients().get("Banaan"));
    }

    @Test
    public void checkStockIngredient_returnsZero_whenNoneExists()
    {
        assertEquals(0, storage.checkStockIngredient("Banaan"));
    }

    @Test
    public void canGetIngredient_andReturnEmptyStockAfterwards()
    {
        storage.addIngredient("Banaan");
        storage.getIngredient("Banaan", 1);
        assertEquals(0, storage.checkStockIngredient("Banaan"));
    }
}