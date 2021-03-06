package org.jboss.da.listings.impl.service;

import org.jboss.da.common.version.VersionParser;
import org.jboss.da.communication.model.GAV;
import org.jboss.da.listings.api.dao.ArtifactDAO;
import org.jboss.da.listings.api.model.Artifact;
import org.jboss.da.listings.api.service.ArtifactService;
import org.jboss.da.reports.backend.impl.VersionFinderImpl;

import javax.inject.Inject;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 
 * @author Jozef Mrazek <jmrazek@redhat.com>
 * @author Jakub Bartecek <jbartece@redhat.com>
 *
 */
public abstract class ArtifactServiceImpl<T extends Artifact> implements ArtifactService<T> {

    @Inject
    protected VersionParser versionParser;

    protected abstract ArtifactDAO<T> getDAO();

    @Override
    public List<T> getAll() {
        return getDAO().findAll();
    }

    @Override
    public boolean isArtifactPresent(GAV gav) {
        return isArtifactPresent(gav.getGroupId(), gav.getArtifactId(), gav.getVersion());
    }

    @Override
    public boolean removeArtifact(String groupId, String artifactId, String version) {
        T artifact = getDAO().findArtifact(groupId, artifactId, version);
        if (artifact != null) {
            getDAO().delete(artifact);
            return true;
        }
        return false;
    }
}
