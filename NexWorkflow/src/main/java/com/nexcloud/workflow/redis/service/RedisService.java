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
package com.nexcloud.workflow.redis.service;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> template;
    
    @Resource(name="redisTemplate") 
    private ValueOperations<String, String> valueOps; 
    
    @Resource(name = "redisTemplate") 
    private ListOperations<String, String> listOps; 
    
    @Resource(name = "redisTemplate") 
    private HashOperations<String, String, String> hashOps; 
    
    @Resource(name = "redisTemplate") 
    private SetOperations<String, String> setOps; 
    
    @Resource(name="redisTemplate") 
    private ZSetOperations<String, String> zSetOps;
    
    
    public synchronized void put( String key, String hashKey, String data)
    {
    	try{
    		hashOps.put(key, hashKey, data);
    	}catch(Exception e){
    		
    	}
    }
    
    public synchronized String get( String key, String hashKey)
    {
    	String data = null;
    	try{
    		data = hashOps.get(key, hashKey);
    	}catch(Exception e){
    		//e.printStackTrace();
    		data	= "";
    	}
    	return data;
    }
    
    public void remove( String key, String hashKey )
    {
    	try{
    		hashOps.delete(key, hashKey);
    	}catch(Exception e){
    		
    	}
    }
}
