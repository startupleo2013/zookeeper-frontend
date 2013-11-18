package org.github.lli.zookeeper.frontend.persistence.model;

import java.io.IOException;
import java.util.Properties;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

/***
 * 
 * @author startupleo2013
 * 
 */
public class RESTFulServiceUtils {
	private static Logger logger = Logger.getLogger(RESTFulServiceUtils.class);
	private static final String CURATOR_PROPERTIES_FILE = "/curator.properties";
	private static final String MAX_RETRIES = "max.retries";
	private static final String CONNECTION_STRING = "connection.string";
	private static CuratorFramework client;

	static {
		initClient();
	}

	public synchronized static CuratorFramework getCuratorFramework() {
		if (client == null)
			initClient();
		return client;
	}

	private static void initClient() {
		try {
			Properties props = new Properties();
			props.load(RESTFulServiceUtils.class
					.getResourceAsStream(CURATOR_PROPERTIES_FILE));
			int maxRetries = Integer.parseInt(props.getProperty(MAX_RETRIES));
			RetryPolicy policy = new ExponentialBackoffRetry(1000, maxRetries);
			String connectionString = props.getProperty(CONNECTION_STRING);
			client = CuratorFrameworkFactory
					.newClient(connectionString, policy);
			client.start();
		} catch (IOException e) {
			logger.fatal("Failed to load " + CURATOR_PROPERTIES_FILE);
		}
	}
}
