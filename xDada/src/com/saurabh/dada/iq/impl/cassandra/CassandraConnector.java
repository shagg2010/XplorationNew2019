package com.saurabh.dada.iq.impl.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;

public class CassandraConnector {
    private static final Logger LOG = LoggerFactory.getLogger(CassandraConnector.class);

    private Cluster cluster;
    private Session session;
    private String msg="";

    public void connect(final String node, final Integer port) {

        Builder b = Cluster.builder().addContactPoint(node);

        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();

        Metadata metadata = cluster.getMetadata();
        msg = "Cluster name: " + metadata.getClusterName();
        LOG.info(msg); System.out.println(msg);

        for (Host host : metadata.getAllHosts()) {
        	msg = "Datacenter: " + host.getDatacenter() + " Host: " + host.getAddress() + " Rack: " + host.getRack();
            LOG.info(msg); System.out.println(msg);
        }

        session = cluster.connect();
        msg = "Connected to Cassandra Cluster with Session hosts: " + session.getState().getConnectedHosts() + " and logged keyspace: " + session.getLoggedKeyspace();
        LOG.info(msg); System.out.println(msg);
    }

    public Session getSession() {
        return this.session;
    }

    public void closeConnector() {
        session.close();
        cluster.close();
    }
}
