package cn.hui.javapro.list.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
	static Map<String, String> mp = new ConcurrentHashMap();
	public static void main(String[] args) {
		
	}

}

class MapP implements Runnable {
	@Override
	public void run() {
		for (int a = 0; a < 10; a++) {
			ConcurrentHashMapDemo.mp.put(String.valueOf(a), "iiii");
		}
	}
}

class MapG implements Runnable {
	@Override
	public void run() {
		for (int a = 0; a < 10; a++) {
			String g = ConcurrentHashMapDemo.mp.get(String.valueOf(a));
			if(!"iiii".equals(g)) {
				System.out.println("------");
			}
		}
	}
}