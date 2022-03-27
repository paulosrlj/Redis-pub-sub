package br.com.ifpb.socket;

public class ChannelSubscribe {
	public static void main(String[] args) {
		RedisServer server = new RedisServer();
		server.connectRedis();
		server.subscribe("C1");
	}
}
