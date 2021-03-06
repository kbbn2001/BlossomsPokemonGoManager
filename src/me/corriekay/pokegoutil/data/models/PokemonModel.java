package me.corriekay.pokegoutil.data.models;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import com.pokegoapi.api.pokemon.Evolutions;
import com.pokegoapi.api.pokemon.Pokemon;
import com.pokegoapi.exceptions.NoSuchItemException;

import POGOProtos.Enums.PokemonIdOuterClass.PokemonId;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import me.corriekay.pokegoutil.utils.helpers.DateHelper;
import me.corriekay.pokegoutil.utils.pokemon.PokeHandler;
import me.corriekay.pokegoutil.utils.pokemon.PokemonCalculationUtils;
import me.corriekay.pokegoutil.utils.pokemon.PokemonUtils;

public class PokemonModel {
    private static final String UNDERSCORE = "_";
    private final IntegerProperty numId = new SimpleIntegerProperty();
    private final StringProperty nickname = new SimpleStringProperty();
    private final StringProperty species = new SimpleStringProperty();
    private final DoubleProperty level = new SimpleDoubleProperty();
    private final StringProperty iv = new SimpleStringProperty();
    private final IntegerProperty atk = new SimpleIntegerProperty();
    private final IntegerProperty def = new SimpleIntegerProperty();
    private final IntegerProperty stam = new SimpleIntegerProperty();
    private final StringProperty type1 = new SimpleStringProperty();
    private final StringProperty type2 = new SimpleStringProperty();
    private final StringProperty move1 = new SimpleStringProperty();
    private final StringProperty move2 = new SimpleStringProperty();
    private final IntegerProperty cp = new SimpleIntegerProperty();
    private final IntegerProperty hp = new SimpleIntegerProperty();
    private final IntegerProperty maxCp = new SimpleIntegerProperty();
    private final IntegerProperty maxCpCurrent = new SimpleIntegerProperty();
    private final IntegerProperty maxEvolvedCpCurrent = new SimpleIntegerProperty();
    private final IntegerProperty maxEvolvedCp = new SimpleIntegerProperty();
    private final IntegerProperty candies = new SimpleIntegerProperty();
    private final IntegerProperty candies2Evlv = new SimpleIntegerProperty();
    private final IntegerProperty dustToLevel = new SimpleIntegerProperty();
    private final StringProperty pokeball = new SimpleStringProperty();
    private final StringProperty caughtDate = new SimpleStringProperty();
    private final BooleanProperty isFavorite = new SimpleBooleanProperty();
    private final LongProperty duelAbility = new SimpleLongProperty();
    private final DoubleProperty gymOffense = new SimpleDoubleProperty();
    private final LongProperty gymDefense = new SimpleLongProperty();
    private final LongProperty duelAbilityIv = new SimpleLongProperty();
    private final DoubleProperty gymOffenseIv = new SimpleDoubleProperty();
    private final LongProperty gymDefenseIv = new SimpleLongProperty();
    private final StringProperty cpEvolved = new SimpleStringProperty();
    private final StringProperty evolvable = new SimpleStringProperty();

    private Pokemon pokemon;

    public PokemonModel(final Pokemon pokemon) {
        this.pokemon = pokemon;
        initialize();
    }

    public IntegerProperty atkProperty() {
        return atk;
    }

    public IntegerProperty candies2EvlvProperty() {
        return candies2Evlv;
    }

    public IntegerProperty candiesProperty() {
        return candies;
    }

    public StringProperty caughtDateProperty() {
        return caughtDate;
    }

    public StringProperty cpEvolvedProperty() {
        return cpEvolved;
    }

    public IntegerProperty cpProperty() {
        return cp;
    }

    public IntegerProperty defProperty() {
        return def;
    }

    public LongProperty duelAbilityIvProperty() {
        return duelAbilityIv;
    }

    public LongProperty duelAbilityProperty() {
        return duelAbility;
    }

    public IntegerProperty dustToLevelProperty() {
        return dustToLevel;
    }

    public StringProperty evolvableProperty() {
        return evolvable;
    }

    public int getAtk() {
        return atk.get();
    }

    public int getCandies() {
        return candies.get();
    }

    public int getCandies2Evlv() {
        return candies2Evlv.get();
    }

    public int getCandyCostsForPowerup() {
        return pokemon.getCandyCostsForPowerup();
    }

    public String getCaughtDate() {
        return caughtDate.get();
    }

    public int getCp() {
        return cp.get();
    }

    public String getCpEvolved() {
        return cpEvolved.get();
    }

    public int getDef() {
        return def.get();
    }

    public long getDuelAbility() {
        return duelAbility.get();
    }

    public long getDuelAbilityIv() {
        return duelAbilityIv.get();
    }

    public int getDustToLevel() {
        return dustToLevel.get();
    }

    public String getEvolvable() {
        return evolvable.get();
    }

    public long getGymDefense() {
        return gymDefense.get();
    }

    public long getGymDefenseIv() {
        return gymDefenseIv.get();
    }

    public double getGymOffense() {
        return gymOffense.get();
    }

    public double getGymOffenseIv() {
        return gymOffenseIv.get();
    }

    public int getHp() {
        return hp.get();
    }

    public String getIv() {
        return iv.get();
    }

    public double getLevel() {
        return level.get();
    }

    public int getMaxCp() {
        return maxCp.get();
    }

    public int getMaxCpCurrent() {
        return maxCpCurrent.get();
    }

    public int getMaxEvolvedCp() {
        return maxEvolvedCp.get();
    }

    public int getMaxEvolvedCpCurrent() {
        return maxEvolvedCpCurrent.get();
    }

    public String getMove1() {
        return move1.get();
    }

    public String getMove2() {
        return move2.get();
    }

    public String getNickname() {
        return nickname.get();
    }

    public int getNumId() {
        return numId.get();
    }

    public String getPokeball() {
        return pokeball.get();
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public String getSpecies() {
        return species.get();
    }

    public int getStam() {
        return stam.get();
    }

    public int getStardustCostsForPowerup() {
        return pokemon.getStardustCostsForPowerup();
    }

    public String getSummary() {
        return String.format(
                "%s (%s) IV: %s CP: %d",
                getNickname(), getSpecies(),
                getIv(), getCp());
    }

    public String getType1() {
        return type1.get();
    }

    public String getType2() {
        return type2.get();
    }

    public LongProperty gymDefenseIvProperty() {
        return gymDefenseIv;
    }

    public LongProperty gymDefenseProperty() {
        return gymDefense;
    }

    public DoubleProperty gymOffenseIvProperty() {
        return gymOffenseIv;
    }

    public DoubleProperty gymOffenseProperty() {
        return gymOffense;
    }

    public IntegerProperty hpProperty() {
        return hp;
    }

    private void initialize() {
        initializePokemonCharacteristicData();
        setMaxCp(getMaxCpForCurrentPokemon());
        setMaxCpCurrent(getMaxCpCurrentForCurrentPokemon());
        setMaxEvolvedCp(getMaxEvolvedCpForHighestEvolution());
        setMaxEvolvedCpCurrent(getMaxEvolvedCpCurrentForHighestEvolution());
        initializeCandiesStatus();
        initializePokemonDataAssciatedWithTrainer();
    }

    private void initializePokemonDataAssciatedWithTrainer() {
        setDustToLevel(pokemon.getStardustCostsForPowerup());
        setPokeball(getPokeballMessage());
        setCaughtDate(DateHelper.toString(DateHelper.fromTimestamp(pokemon.getCreationTimeMs())));
        setIsFavorite(pokemon.isFavorite());
        setDuelAbility(PokemonCalculationUtils.duelAbility(pokemon));
        setGymOffense(PokemonCalculationUtils.gymOffense(pokemon));
        setGymDefense(PokemonCalculationUtils.gymDefense(pokemon));
        setDuelAbilityIv(PokemonCalculationUtils.duelAbility(pokemon));
        setGymOffenseIv(PokemonCalculationUtils.gymOffense(pokemon));
        setGymDefenseIv(PokemonCalculationUtils.gymDefense(pokemon));
    }

    private String getPokeballMessage() {
        return WordUtils.capitalize(
                getPokeballString().replaceAll("item_", "").replaceAll(UNDERSCORE, " "));
    }

    private String getPokeballString() {
        return pokemon.getPokeball().toString().toLowerCase();
    }

    private void initializeCandiesStatus() {
        setCandies(pokemon.getCandy());
        if (pokemon.getCandiesToEvolve() != 0) {
            setCandies2Evlv(pokemon.getCandiesToEvolve());
            setEvolvable(String.valueOf((int) ((double) getCandies() / pokemon.getCandiesToEvolve())));
        } else {
            setCandies2Evlv(0);
            setEvolvable("-");
        }
    }

    private int getMaxEvolvedCpForHighestEvolution() {
        return new PokemonCpOriginalProvider(pokemon).getMaxEvolvedCp();
    }

    private int getMaxEvolvedCpCurrentForHighestEvolution() {
        return new PokemonCpCurrentProvider(pokemon).getMaxEvolvedCp();
    }

    private int getMaxCpForCurrentPokemon() {
        return new PokemonCpOriginalProvider(pokemon).getMaxCp();
    }

    private int getMaxCpCurrentForCurrentPokemon() {
        return new PokemonCpCurrentProvider(pokemon).getMaxCp();
    }

    private void initializePokemonCharacteristicData() {
        setNumId(getPokemonIdValue());
        setNickname(pokemon.getNickname());
        setSpecies(PokemonUtils.getLocalPokeName(pokemon));
        setLevel(pokemon.getLevel());
        setIv(PokeHandler.ReplacePattern.IV_RATING.get(pokemon));
        setAtk(pokemon.getIndividualAttack());
        setDef(pokemon.getIndividualDefense());
        setStam(pokemon.getIndividualStamina());
        setType1(StringUtils.capitalize(getPokemonType()));
        setType2(StringUtils.capitalize(getPokemonType2()));
        setMove1(String.format("%s (%.2fdps)",
                WordUtils.capitalize(getPokemonMove1Message()),
                PokemonCalculationUtils.dpsForMove(pokemon, true)));
        setMove2(String.format("%s (%.2fdps)",
                WordUtils.capitalize(getPokemonMove2Message()),
                PokemonCalculationUtils.dpsForMove(pokemon, false)));
        setCp(pokemon.getCp());
        setHp(pokemon.getMaxStamina());
    }

    private String getPokemonMove2Message() {
        return getPokemonMove2()
                .replaceAll("_fast", "").replaceAll(UNDERSCORE, " ");
    }

    private String getPokemonMove1Message() {
        return getPokemonMove1()
                .replaceAll("_fast", "").replaceAll(UNDERSCORE, " ");
    }

    private String getPokemonMove2() {
        return pokemon.getMove2().toString().toLowerCase();
    }

    private String getPokemonMove1() {
        return pokemon.getMove1().toString().toLowerCase();
    }

    private String getPokemonType2() {
        return pokemon.getSettings().getType2().toString().toLowerCase();
    }

    private String getPokemonType() {
        return pokemon.getSettings().getType().toString().toLowerCase();
    }

    private int getPokemonIdValue() {
        return pokemon.getSettings().getPokemonIdValue();
    }

    public BooleanProperty isFavoriteProperty() {
        return isFavorite;
    }

    public boolean isInGym() {
        return !pokemon.getDeployedFortId().isEmpty();
    }

    public boolean isIsFavorite() {
        return isFavorite.get();
    }

    public StringProperty ivProperty() {
        return iv;
    }

    public DoubleProperty levelProperty() {
        return level;
    }

    public IntegerProperty maxCpCurrentProperty() {
        return maxCpCurrent;
    }

    public IntegerProperty maxCpProperty() {
        return maxCp;
    }

    public IntegerProperty maxEvolvedCpCurrentProperty() {
        return maxEvolvedCpCurrent;
    }

    public IntegerProperty maxEvolvedCpProperty() {
        return maxEvolvedCp;
    }

    public StringProperty move1Property() {
        return move1;
    }

    public StringProperty move2Property() {
        return move2;
    }

    public StringProperty nicknameProperty() {
        return nickname;
    }

    public IntegerProperty numIdProperty() {
        return numId;
    }

    public StringProperty pokeballProperty() {
        return pokeball;
    }

    public void setAtk(final int atk) {
        this.atk.set(atk);
    }

    public void setCandies(final int candies) {
        this.candies.set(candies);
    }

    public void setCandies2Evlv(final int candies2Evlv) {
        this.candies2Evlv.set(candies2Evlv);
    }

    public void setCaughtDate(final String caughtDate) {
        this.caughtDate.set(caughtDate);
    }

    public void setCp(final int cp) {
        this.cp.set(cp);
    }

    public void setCpEvolved(final String cpEvolved) {
        this.cpEvolved.set(cpEvolved);
    }

    public void setDef(final int def) {
        this.def.set(def);
    }

    public void setDuelAbility(final long duelAbility) {
        this.duelAbility.set(duelAbility);
    }

    public void setDuelAbilityIv(final long duelAbilityIv) {
        this.duelAbilityIv.set(duelAbilityIv);
    }

    public void setDustToLevel(final int dustToLevel) {
        this.dustToLevel.set(dustToLevel);
    }

    public void setEvolvable(final String evolvable) {
        this.evolvable.set(evolvable);
    }

    public void setGymDefense(final long gymDefense) {
        this.gymDefense.set(gymDefense);
    }

    public void setGymDefenseIv(final long gymDefenseIv) {
        this.gymDefenseIv.set(gymDefenseIv);
    }

    public void setGymOffense(final double gymOffense) {
        this.gymOffense.set(gymOffense);
    }

    public void setGymOffenseIv(final double gymOffenseIv) {
        this.gymOffenseIv.set(gymOffenseIv);
    }

    public void setHp(final int hp) {
        this.hp.set(hp);
    }

    public void setIsFavorite(final boolean isFavorite) {
        this.isFavorite.set(isFavorite);
    }

    public void setIv(final String iv) {
        this.iv.set(iv);
    }

    public void setLevel(final double level) {
        this.level.set(level);
    }

    public void setMaxCp(final int maxCp) {
        this.maxCp.set(maxCp);
    }

    public void setMaxCpCurrent(final int maxCpCurrent) {
        this.maxCpCurrent.set(maxCpCurrent);
    }

    public void setMaxEvolvedCp(final int maxEvolvedCp) {
        this.maxEvolvedCp.set(maxEvolvedCp);
    }

    public void setMaxEvolvedCpCurrent(final int maxEvolvedCpCurrent) {
        this.maxEvolvedCpCurrent.set(maxEvolvedCpCurrent);
    }

    public void setMove1(final String move1) {
        this.move1.set(move1);
    }

    public void setMove2(final String move2) {
        this.move2.set(move2);
    }

    public void setNickname(final String nickname) {
        this.nickname.set(nickname);
    }

    public void setNumId(final int numId) {
        this.numId.set(numId);
    }

    public void setPokeball(final String pokeball) {
        this.pokeball.set(pokeball);
    }

    public void setPokemon(final Pokemon pokemon) {
        this.pokemon = pokemon;
        initialize();
    }

    public void setSpecies(final String species) {
        this.species.set(species);
    }

    public void setStam(final int stam) {
        this.stam.set(stam);
    }

    public void setType1(final String type1) {
        this.type1.set(type1);
    }

    public void setType2(final String type2) {
        this.type2.set(type2);
    }

    public StringProperty speciesProperty() {
        return species;
    }

    public IntegerProperty stamProperty() {
        return stam;
    }

    public StringProperty type1Property() {
        return type1;
    }

    public StringProperty type2Property() {
        return type2;
    }
}