package io.edurt.datacap.plugin;

import io.edurt.datacap.plugin.utils.PluginPathUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;

public class PluginManagerTest
{
    private PluginManager pluginManager;

    @Before
    public void before()
    {
        Path projectRoot = PluginPathUtils.findProjectRoot();
        PluginConfig config = PluginConfig.builder()
                .pluginsDir(projectRoot.resolve("test/datacap-test-plugin"))
                .build();

        pluginManager = new PluginManager(config);
        pluginManager.start();
    }

    @Test
    public void testLoadPlugin()
    {
        Assert.assertFalse(pluginManager.getPlugin("Local").isEmpty());
    }

    @Test
    public void testService()
    {
        pluginManager.getPlugin("Local")
                .ifPresent(value -> {
                    Service service = value.getService(Service.class);
                });
    }
}
