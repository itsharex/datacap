package io.edurt.datacap.plugin.service;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import io.edurt.datacap.plugin.Service;

public class ServiceBindings
{
    // 限制绑定类型必须是 Service 的子类
    // Restrict binding types to Service subclasses
    private final Multimap<Class<? extends Service>, Class<? extends Service>> bindings = LinkedListMultimap.create();

    /**
     * 添加服务绑定
     * Add service binding
     *
     * @param serviceType 服务类型（必须继承自Service）
     * @param serviceType service type (must extend Service)
     * @param implementationType 实现类型（必须继承自Service）
     * @param implementationType implementation type (must extend Service)
     */
    public void addBinding(Class<? extends Service> serviceType, Class<? extends Service> implementationType)
    {
        bindings.put(serviceType, implementationType);
    }

    /**
     * 获取所有绑定
     * Get all bindings
     *
     * @return 服务绑定映射
     * @return service binding mapping
     */
    public Multimap<Class<? extends Service>, Class<? extends Service>> getBindings()
    {
        return bindings;
    }
}
