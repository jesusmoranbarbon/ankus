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

import org.openflamingo.core.repository.PersistentRepository;
import org.openflamingo.model.rest.User;

import java.util.List;

public interface UserAdminRepository extends PersistentRepository<User, Long> {

    public static final String NAMESPACE = UserAdminRepository.class.getName();

    List<User> selectAll();

    List<User> selectByCondition(String jobType, String createDate, String username, String email, String enabled, String authority, String orderBy, String desc, int start, int limit);

    int updateUser(User user);

    int deleteUser(User user);

    boolean selectByName(String username);
}