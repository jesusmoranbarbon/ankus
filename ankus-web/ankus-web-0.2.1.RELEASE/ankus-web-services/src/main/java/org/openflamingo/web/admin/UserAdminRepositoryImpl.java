/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openflamingo.web.admin;

import org.mybatis.spring.SqlSessionTemplate;
import org.openflamingo.core.repository.PersistentRepositoryImpl;
import org.openflamingo.model.rest.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openflamingo.util.StringUtils.isEmpty;

@Repository
public class UserAdminRepositoryImpl extends PersistentRepositoryImpl<User, Long> implements UserAdminRepository {

    @Override
    public String getNamespace() {
        return NAMESPACE;
    }

    @Autowired
    public UserAdminRepositoryImpl(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public List<User> selectAll() {
        return this.getSqlSessionTemplate().selectList(this.getNamespace() + ".selectAll");
    }

    @Override
    public List<User> selectByCondition(String jobType, String createDate, String username, String email, String enabled, String authority, String orderBy, String desc, int start, int limit) {
        Map params = new HashMap();
        if (!isEmpty("username")) params.put("username", username);
        if (!isEmpty("jobType")) params.put("jobType", jobType);
        if (!isEmpty("createDate")) params.put("createDate", createDate);
        if (!isEmpty("email")) params.put("email", email);
        if (!isEmpty("enabled")) params.put("enabled", enabled);
        if (!isEmpty("authority")) params.put("authority", authority);

        params.put("orderBy", orderBy);
        params.put("desc", desc);
        params.put("start", start);
        params.put("limit", limit);

        return this.getSqlSessionTemplate().selectList(this.getNamespace() + ".selectByCondition", params);
    }

    @Override
    public boolean selectByName(String username) {
        return this.getSqlSessionTemplate().selectOne(this.getNamespace() + ".selectByName", username);
    }

    @Override
    public int updateUser(User user) {
        return this.getSqlSessionTemplate().update(this.getNamespace() + ".updateUser", user);
    }

    @Override
    public int deleteUser(User user) {
        return this.getSqlSessionTemplate().delete(this.getNamespace() + ".deleteUser", user);
    }

}
