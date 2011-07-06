/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.hadoop.yarn.server.resourcemanager.scheduler;

import java.io.IOException;

import org.apache.hadoop.classification.InterfaceAudience.LimitedPrivate;
import org.apache.hadoop.classification.InterfaceStability.Evolving;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.event.EventHandler;
import org.apache.hadoop.yarn.server.resourcemanager.applicationsmanager.events.ASMEvent;
import org.apache.hadoop.yarn.server.resourcemanager.applicationsmanager.events.ApplicationTrackerEventType;
import org.apache.hadoop.yarn.server.resourcemanager.recovery.Recoverable;
import org.apache.hadoop.yarn.server.resourcemanager.resourcetracker.ClusterTracker;
import org.apache.hadoop.yarn.server.security.ContainerTokenSecretManager;

/**
 * This interface is the one implemented by the schedulers. It mainly extends 
 * {@link ResourceListener} and {@link YarnScheduler}. 
 *
 */
@LimitedPrivate("yarn")
@Evolving
public interface ResourceScheduler extends ResourceListener, YarnScheduler, 
  EventHandler<ASMEvent<ApplicationTrackerEventType>>, Recoverable {
  /**
   * Re-initialize the <code>ResourceScheduler</code>.
   * @param conf configuration
   * @param secretManager token-secret manager
   * @throws IOException
   */
  void reinitialize(Configuration conf, 
      ContainerTokenSecretManager secretManager, ClusterTracker clusterTracker) throws IOException;    
}
