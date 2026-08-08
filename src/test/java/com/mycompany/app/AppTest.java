package com.mycompany.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testAppConstructor() {
        App app1 = new App();
        App app2 = new App();
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    @Test
    public void testAppMessage()
    {
        App app = new App();
        assertEquals("Hello World!", app.getMessage());
    }

    @Test
    @DisabledIfEnvironmentVariable(named="WORKSPACE", matches="^[C-Z]:") // Disable on Windows CI
    public void testDisabledOnWindows()
    {
        App app = new App();
        assertEquals("Hello World!", app.getMessage());
    }
}
