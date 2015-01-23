package com.bitcamp.serverandclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.plaf.SliderUI;

public class SocketConnector {

	// umjesto 127.0.0.1. moze i localHost
	public static final String serverAdress = "127.0.0.1";
	// port mora biti isti ako i kod servera!!
	public static final int port = 1728;

	/**
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */

	private static void connectToServer() throws UnknownHostException,
			IOException {

		Socket client = new Socket(serverAdress, port);

		SocketRW sc = new SocketRW(client.getInputStream(),
				client.getOutputStream());
		sc.recieve();
		sc.send("Hello from client");

		System.out.println("\nGotovo");
		client.close();

	}

	public static void main(String[] args) {
		try {
			connectToServer();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
