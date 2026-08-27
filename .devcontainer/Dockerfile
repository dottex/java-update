# Use a base image with Ubuntu
FROM mcr.microsoft.com/devcontainers/base:ubuntu

# Install basic tools
RUN apt-get update && apt-get install -y curl zip unzip

# Install SDKMAN!
RUN curl -s "https://get.sdkman.io" | bash

# Install Java 21 using SDKMAN!
RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 21.0.2-tem"

# Set JAVA_HOME and PATH (optional but good for consistency)
ENV JAVA_HOME="/root/.sdkman/candidates/java/current"
ENV PATH="$JAVA_HOME/bin:$PATH"
