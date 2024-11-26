package io.edurt.datacap.plugin.solr

import io.edurt.datacap.spi.PluginService

class SolrPlugin : _root_ide_package_.io.edurt.datacap.spi.PluginService
{
    override fun validator(): String
    {
        return "SELECT '-' AS version"
    }

    override fun driver(): String
    {
        return "org.apache.solr.client.solrj.io.sql.DriverImpl"
    }

    override fun connectType(): String
    {
        return "solr"
    }
}
