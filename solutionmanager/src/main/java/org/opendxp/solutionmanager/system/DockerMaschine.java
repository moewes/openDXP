package org.opendxp.solutionmanager.system;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.netty.NettyDockerCmdExecFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DockerMaschine {

  public String getInfo() {

    // using jaxrs/jersey implementation here (netty impl is also available)
    DockerCmdExecFactory dockerCmdExecFactory = new NettyDockerCmdExecFactory();
        /*    .withReadTimeout(1000)
            .withConnectTimeout(1000)
            .withMaxTotalConnections(100)
            .withMaxPerRouteConnections(10);*/

    DockerClient dockerClient = DockerClientBuilder.getInstance().withDockerCmdExecFactory(dockerCmdExecFactory).build();

    Info exec = dockerClient.infoCmd().exec();

    return exec.getArchitecture();

/*
    try {
      final DockerClient docker = new DefaultDockerClient("unix:///var/run/docker.sock");
      Info info = docker.info();

      return info.name();
    } catch (DockerException | InterruptedException e) {
      e.printStackTrace();
    }
    return "sorry";*/
  }
}
