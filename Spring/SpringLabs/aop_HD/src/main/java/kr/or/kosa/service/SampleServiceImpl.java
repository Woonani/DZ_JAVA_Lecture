package kr.or.kosa.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{

	@Override
	public void doadd(int a, int b) throws Exception {
		int result = a+b;
		System.out.println("Result : " + result);
	}

	@Override
	public void dominus(int a, int b) throws Exception {
		int result = a-b;
		System.out.println("Result : " + result);
	}

	@Override
	public void domultiply(int a, int b) throws Exception {
		int result = a*b;
		System.out.println("Result : " + result);
	}
	
	@Override
	public void dodivide(int a, int b) throws Exception {
		int result = a/b;
		System.out.println("Result : " + a/b);
	}

}

