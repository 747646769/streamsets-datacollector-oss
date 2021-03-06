/*
 * Copyright 2020 StreamSets Inc.
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
package com.streamsets.pipeline.stage.origin.startJob;

import com.streamsets.pipeline.api.ConfigDefBean;
import com.streamsets.pipeline.api.ConfigGroups;
import com.streamsets.pipeline.api.ExecutionMode;
import com.streamsets.pipeline.api.GenerateResourceBundle;
import com.streamsets.pipeline.api.HideConfigs;
import com.streamsets.pipeline.api.Source;
import com.streamsets.pipeline.api.StageDef;
import com.streamsets.pipeline.api.base.configurablestage.DSource;
import com.streamsets.pipeline.lib.startJob.StartJobConfig;
import com.streamsets.pipeline.lib.startJob.Groups;

@StageDef(
    version = 6,
    label = "Start Jobs",
    description = "Starts Control Hub jobs",
    icon="job.png",
    recordsByRef = true,
    execution = {
        ExecutionMode.STANDALONE
    },
    onlineHelpRefUrl ="index.html?contextID=task_mmx_1n3_plb",
    upgraderDef = "upgrader/StartJobDSource.yaml"
)
@GenerateResourceBundle
@HideConfigs({
    "conf.controlHubConfig.client.tlsConfig.useRemoteKeyStore",
    "conf.controlHubConfig.client.tlsConfig.keyStoreFilePath",
    "conf.controlHubConfig.client.tlsConfig.privateKey",
    "conf.controlHubConfig.client.tlsConfig.certificateChain",
    "conf.controlHubConfig.client.tlsConfig.keyStoreType",
    "conf.controlHubConfig.client.tlsConfig.keyStorePassword",
    "conf.controlHubConfig.client.tlsConfig.keyStoreAlgorithm",
    "conf.controlHubConfig.client.requestLoggingConfig.enableRequestLogging",
    "conf.controlHubConfig.client.numThreads",
})
@ConfigGroups(Groups.class)
public class StartJobDSource extends DSource {

  @ConfigDefBean
  public StartJobConfig conf;

  @Override
  protected Source createSource() {
    return new StartJobSource(conf);
  }
}
