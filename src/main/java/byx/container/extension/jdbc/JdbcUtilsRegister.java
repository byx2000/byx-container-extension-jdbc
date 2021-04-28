package byx.container.extension.jdbc;

import byx.ioc.core.Container;
import byx.ioc.core.ContainerCallback;
import byx.ioc.core.Dependency;
import byx.ioc.core.ObjectDefinition;
import byx.util.jdbc.JdbcUtils;

import javax.sql.DataSource;

/**
 * 注册JdbcUtils
 *
 * @author byx
 */
public class JdbcUtilsRegister implements ContainerCallback {
    @Override
    public void afterContainerInit(Container container) {
        container.registerObject("jdbcUtils", new ObjectDefinition() {
            @Override
            public Class<?> getType() {
                return JdbcUtils.class;
            }

            @Override
            public Dependency[] getInstanceDependencies() {
                return new Dependency[]{Dependency.type(DataSource.class)};
            }

            @Override
            public Object getInstance(Object[] params) {
                return new JdbcUtils((DataSource) params[0]);
            }
        });
    }
}
