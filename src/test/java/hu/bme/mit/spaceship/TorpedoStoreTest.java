package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void testTooMuchToFire() throws IllegalArgumentException{
        TorpedoStore store = new TorpedoStore(1);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {store.fire(60);});
        assertEquals("numberOfTorpedos", thrown.getMessage());
    }

    @Test
    void testTooFewToFire() throws IllegalArgumentException{
        TorpedoStore store = new TorpedoStore(1);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {store.fire(0);});
        assertEquals("numberOfTorpedos", thrown.getMessage());
    }

    @Test
    void testFireSuccess(){
        TorpedoStore store = new TorpedoStore(2, 0);
        boolean res = store.fire(1);
        int left = store.getTorpedoCount();
        assertEquals(true, res);
        assertEquals(1, left);
    }

    @Test
    void testFireFail(){
        TorpedoStore store = new TorpedoStore(2, 1);
        boolean res = store.fire(1);
        int left = store.getTorpedoCount();
        assertEquals(false, res);
        assertEquals(2, left);
    }

    @Test
    void testEmptyStore() {
        TorpedoStore store = new TorpedoStore(0);
        assertEquals(true, store.isEmpty());
    }


}
