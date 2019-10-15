/*
* Copyright 2019 NexCloud Co.,Ltd.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.nexcloud.workflow.docker.resource;
import java.util.Hashtable;

public class ResourceLoader{	
	private static Hashtable<String, Object> resourceMap = null;
	private static ResourceLoader thisObj = null;

	/**
	 *	config파일이 변경되었을경우 재로딩하기위해사용
	 *
	 *	@param		
	 *	@see
	 *	@exception
	 *	@exception	
	 */
	public static void getReload(){
		if(resourceMap != null)
			resourceMap.clear();
		init();
	}
	

	public synchronized static ResourceLoader getInstance(){
		if ( thisObj == null ){
			System.out.println("ConfigLoader getInstance 실행!!!!!!!!!!!!!!!");
			try {
				thisObj = new ResourceLoader();
				if(resourceMap == null)
					ResourceLoader.init();
			}catch(IndexOutOfBoundsException ie){
				System.out.println("ResourceLoader Class getInstance IndexOutOfBoundsException Error = " +ie);
			}catch(NullPointerException ne){
				System.out.println("ResourceLoader Class getInstance NullPointerException Error = " +ne);
			} catch(Exception e) {
				System.out.println("ResourceLoader Class getInstance Exception Error = " + e);
			}	
		}	
		
		return thisObj;
	}
	
	/**
	 *	config파일을 로딩함.
	 *
	 *	@param		
	 *	@see		
	 *	@exception	IndexOutOfBoundsException - 문제발생시
	 *	@exception	NullPointerException - 문제발생시
	 */
	public static void init()
	{
		try{
			System.out.println("ConfigLoader init 실행!!!!!!!!!!!!!!!");
			resourceMap	= null;
			resourceMap = new Hashtable<String, Object>();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Resource Data Set
	 * @param key
	 * @param object
	 */
	public void setResource(String key, Object object)
	{
		resourceMap.put(key, object);
	}
	
	/**
	 * Resource Data Remove
	 */
	public void removeResource(String key)
	{
		resourceMap.remove(key);
	}
	
	/**
	 * Resource Data Get
	 * @param key
	 * @return
	 */
	public Object getResource(String key)
	{
		return resourceMap.get(key);
	}
}
