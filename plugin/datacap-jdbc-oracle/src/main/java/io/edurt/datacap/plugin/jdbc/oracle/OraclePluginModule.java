package io.edurt.datacap.plugin.jdbc.oracle;

import com.google.inject.multibindings.Multibinder;
import io.edurt.datacap.spi.AbstractPluginModule;
import io.edurt.datacap.spi.PluginService;
import io.edurt.datacap.spi.PluginModule;
import io.edurt.datacap.spi.PluginType;

public class OraclePluginModule
        extends AbstractPluginModule
        implements PluginModule
{
    @Override
    public String getName()
    {
        return "Oracle";
    }

    @Override
    public PluginType getType()
    {
        return PluginType.JDBC;
    }

    @Override
    public AbstractPluginModule get()
    {
        return this;
    }

    protected void configure()
    {
        Multibinder<String> module = Multibinder.newSetBinder(this.binder(), String.class);
        module.addBinding().toInstance(this.getClass().getSimpleName());
        Multibinder<PluginService> plugin = Multibinder.newSetBinder(this.binder(), PluginService.class);
        plugin.addBinding().to(OraclePlugin.class);
    }
}
