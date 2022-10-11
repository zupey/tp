package nus.climods.model.module;

import nus.climods.logic.parser.exceptions.ParseException;
import nus.climods.model.module.exceptions.UserModuleNotFoundException;
import nus.climods.model.tag.Tag;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.ModulesApi;
import org.openapitools.client.model.Module;
import org.openapitools.client.api.VenuesApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class UserModule {
    private final ModulesApi api = new ModulesApi();

    // Identity fields
    private final Module userModule;
    private final String acadYear = "2022-2023";

    public UserModule(String moduleCode) throws ParseException{
        try {
            this.userModule = api.acadYearModulesModuleCodeJsonGet(acadYear, moduleCode);
        } catch (ApiException e) {
            throw new ParseException("Module not in current NUS curriculum");
        }
    }

    public Module getUserModule() {return this.userModule;}

    public String getUserModuleCode() {
        return this.userModule.getModuleCode();
    }

    public String getAcadYear() { return this.acadYear;}

    public String getUserModuleTitle() { return this.userModule.getTitle();}

    public String getDepartment() {
        return "Computer Science";
    }

    public String getWorkload() {
        return "4 MCs";
    }

    public String getTitle() {
        return "Software Engineering";
    }

    public String getAcademicYear() {
        return "AY2223";
    }

    public String getTutorial() {
        return "Tutorial: Monday, 1400-1500";
    }

    public String getLecture() {
        return "Lecture: Friday, 1600-1800";
    }

    public ArrayList<String> getSemesterData() {
        return new ArrayList<String>(Arrays.asList("Semester 1", "Semester 2"));
    }

    /**
     * Returns true if both modules have the same name. This defines a weaker notion of equality between two modules.
     */
    public boolean isSameUserModule(UserModule otherModule) {
        if (otherModule == this) {
            return true;
        }

        return otherModule != null
                && otherModule.getUserModuleCode().equals(getUserModuleCode());
    }

    /**
     * Returns true if both modules have the same identity and data fields. This defines a stronger notion of equality
     * between two modules.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof nus.climods.model.module.Module)) {
            return false;
        }

        nus.climods.model.module.Module otherModule = (nus.climods.model.module.Module) other;
        return otherModule.getCode().equals(getUserModuleCode());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(userModule);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getUserModuleCode());

        //TODO: add string builder for other module details
        return builder.toString();
    }

}
