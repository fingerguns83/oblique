package net.fg83.oblique.client;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.text.Text;

import java.util.Random;

import static net.minecraft.server.command.CommandManager.*;


@Environment(EnvType.CLIENT)
public class ObliqueClient implements ClientModInitializer {
    public String newStrategy(){
        String[] strategies = {
                "Abandon normal blocks",
                "Accept advice",
                "Accretion",
                "A line has two sides",
                "Allow an easement (an easement is the abandonment of a stricture)",
                "Are there sections? Consider transitions",
                "Ask people to work against their better judgement",
                "Ask your body",
                "Assemble some of the blocks in a group and treat as one",
                "Balance the consistency principle with the inconsistency principle",
                "Be dirty",
                "Breathe more deeply",
                "Bridges: •build •burn",
                "Cascades",
                "Change block roles",
                "Change nothing and continue with immaculate consistency",
                "Cluster analysis",
                "Consider different fading systems",
                "Consult other sources: •promising •unpromising",
                "Convert a primary element into a support element",
                "Courage!",
                "Cut a vital connection",
                "Decorate, decorate",
                "Define an area as \"safe\" and use it as an anchor",
                "Destroy: •nothing •the most important thing",
                "Discard an axiom",
                "Disconnect from desire",
                "Discover the processes you are using and abandon them",
                "Distorting time",
                "Do nothing for as long as possible",
                "Don't be afraid of things because they're easy to do",
                "Don't be frightened of clichés",
                "Don't be frightened to display your talents",
                "Don't break the silence",
                "Don't stress one thing more than another",
                "Do something boring",
                "Do the dishes",
                "Do the words need changing?",
                "Do we need holes?",
                "Emphasize differences",
                "Emphasize repetitions",
                "Emphasize the flaws",
                "Faced with a choice, do both",
                "Fill every space with something",
                "Get your neck massaged",
                "Ghost echoes",
                "Give the game away",
                "Give way to your worst impulse",
                "Go slowly all the way round the outside",
                "Honor thy error as a hidden intention",
                "How would you have done it?",
                "How would you have done it?",
                "Humanize something free of error",
                "Imagine the build as a moving chain or caterpillar",
                "Imagine the build as a set of disconnected events",
                "Infinitesimal gradations",
                "Intentions: •credibility of •nobility of •humility of",
                "Into the impossible",
                "Is it finished?",
                "Is there something missing?",
                "Just carry on",
                "Listen to the quiet voice",
                "Look at a very small object; look at its center",
                "Look at the order in which you do things",
                "Look closely at the most embarrassing details and amplify them",
                "Lowest common denominator, check: •single block •single layer •single section",
                "Make a blank valuable by putting it in an exquisite frame",
                "Make an exhaustive list of everything you might do and do the last thing on the list",
                "Make a sudden, destructive, unpredictable action; incorporate",
                "Mechanicalize something idiosyncratic",
                "Grayscale and continue (use your computer's display settings)",
                "Only one element of each kind",
                "(Organic) machinery",
                "Overtly resist change",
                "Dim screen as much as possible",
                "Remember those quiet evenings",
                "Remove ambiguities and convert to specifics",
                "Remove specifics and convert to ambiguities",
                "Repetition is a form of change",
                "Reverse",
                "Short circuit (example: a person drinking pomegranate juice with the idea that it will improve their skin pours it straight onto their face)",
                "Observe from far away",
                "Simple subtraction",
                "Take a break",
                "Take away the elements in order of apparent non-importance",
                "The inconsistency principle",
                "Tidy up",
                "Trust in the you of now",
                "Turn it upside down",
                "Twist the spine",
                "Use an old idea",
                "Use an unacceptable color",
                "Use fewer blocks",
                "Use filters",
                "Use \"unqualified\" people",
                "Water",
                "What are you really thinking about just now? Incorporate",
                "What is the reality of the situation?",
                "What mistakes did you make last time?",
                "What would your closest friend do?",
                "What wouldn't you do?",
                "Work at a different speed",
                "You are an engineer",
                "You don't have to be ashamed of using your own ideas",
                "        "
        };
        Random rand = new Random();
        int int_random = rand.nextInt(strategies.length);
        return strategies[int_random];
    }
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    ClientCommandManager.literal("inspireme").executes(context -> {
                        context.getSource().sendFeedback(Text.literal(newStrategy()));
                        return 1;
                    })
            );
        });
    }
}
