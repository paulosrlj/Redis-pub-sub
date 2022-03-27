package br.com.ifpb.socket;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisServer {
	private Jedis jedis = null;

	private String userName = "";

	public RedisServer() {

	}

	public RedisServer(String userName) {
		this.userName = userName;
	}

	private final JedisPubSub jedisPubSub = new JedisPubSub() {
		@Override
		public void onMessage(String canal, String mensagem) {
			System.out.println(mensagem);
		}

		@Override
		public void onSubscribe(String channel, int subscribedChannels) {
			System.out.println("A inscrição no canal " + channel + " está ativa");
		}

		@Override
		public void onUnsubscribe(String channel, int subscribedChannels) {
			System.out.println(userName + " se desinscreveu do canal: " + channel);
		}

	};

	public void connectRedis() {
		try {
			if (this.jedis != null)
				return;

			this.jedis = new Jedis("localhost", 6379);
		} catch (Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
		}
	}

	public void closeConnection() {
		if (jedis != null)
			jedis.close();
	}

	public void publishMessage(String msg) {
		jedis.publish("C1", msg);
	}

	public void subscribe(String channel) {
		jedis.subscribe(jedisPubSub, channel);
	}

	public Jedis getJedis() {
		return this.jedis;
	}

	public JedisPubSub getJedisPubSub() {
		return jedisPubSub;
	}

}
