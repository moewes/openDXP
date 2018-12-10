package org.opendxp.solutionmanager.system;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.Network;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.netty.NettyDockerCmdExecFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class DockerMaschine {

  private DockerClient dockerClient;

  private DockerClient getDockerClient() {

    if (dockerClient == null) {
      DockerCmdExecFactory dockerCmdExecFactory = new NettyDockerCmdExecFactory();
      dockerClient = DockerClientBuilder.getInstance().withDockerCmdExecFactory(dockerCmdExecFactory).build();
    }
    return dockerClient;
  }

  public String getInfo() {

    Info exec = getDockerClient().infoCmd().exec();
    return exec.getArchitecture();
  }

  public List<Network> getNetworks() {

    return getDockerClient().listNetworksCmd().exec();
  }
}
