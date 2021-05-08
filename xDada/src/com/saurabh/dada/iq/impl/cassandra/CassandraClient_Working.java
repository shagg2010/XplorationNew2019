package com.saurabh.dada.iq.impl.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class CassandraClient_Working {

private Session session;

private Cluster cluster;

public void connect(String node) {
    cluster = Cluster.builder().addContactPoint(node).build();
    Metadata metadata = cluster.getMetadata();
    System.out.println("Cassandra connection established");
    System.out.printf("Connected to cluster: %s\n",
            metadata.getClusterName());
    for (Host host : metadata.getAllHosts()) {
        System.out.printf("Datatacenter: %s; Host: %s; Rack: %s \n",
                host.getDatacenter(), host.getAddress(), host.getRack());
        session = cluster.connect();

    }
}

public void createSchema() {
    session.execute("CREATE KEYSPACE simplex WITH replication "
            + "= {'class':'SimpleStrategy', 'replication_factor':3};");

    session.execute("CREATE TABLE simplex.songs (" + "id uuid PRIMARY KEY,"
            + "title text," + "album text," + "artist text,"
            + "tags set<text>," + "data blob" + ");");
    session.execute("CREATE TABLE simplex.playlists (" + "id uuid,"
            + "title text," + "album text, " + "artist text,"
            + "song_id uuid," + "PRIMARY KEY (id, title, album, artist)"
            + ");");

}

public void loadData() {
    session.execute("INSERT INTO simplex.songs (id, title, album, artist, tags) "
            + "VALUES ("
            + "756716f7-2e54-4715-9f00-91dcbea6cf50,"
            + "'La Petite Tonkinoise',"
            + "'Bye Bye Blackbird',"
            + "'Jos�phine Baker'," + "{'jazz', '2013'})" + ";");
    session.execute("INSERT INTO simplex.playlists (id, song_id, title, album, artist) "
            + "VALUES ("
            + "2cc9ccb7-6221-4ccb-8387-f22b6a1b354d,"
            + "756716f7-2e54-4715-9f00-91dcbea6cf50,"
            + "'La Petite Tonkinoise',"
            + "'Bye Bye Blackbird',"
            + "'Jos�phine Baker'" + ");");
}

public void close() {
    cluster.close();
}

public static void main(String[] args) {
	CassandraClient_Working client = new CassandraClient_Working();
    client.connect("127.0.0.1");

    client.createSchema();
    client.close();
}

}
