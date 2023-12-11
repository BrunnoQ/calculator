package br.com.calculator.main;

import static br.com.calculator.utils.converters.OperacaoConverter.inputToDomain;
import static br.com.calculator.utils.converters.OperacaoConverter.domainToOutput;
import static br.com.calculator.utils.json.JsonUtil.jsonToList;
import static br.com.calculator.utils.json.JsonUtil.listToJson;
import br.com.calculator.data.in.OperacaoInput;
import br.com.calculator.data.out.ImpostoOutput;
import br.com.calculator.rules.implementations.RegrasGanhoCapitalAcoesImpl;
import br.com.calculator.rules.interfaces.IRegrasGanhoCapitalAcoes;
import br.com.calculator.service.implementations.ImpostoGanhoCapitalCalculatorImpl;
import br.com.calculator.service.interfaces.IImpostoGanhoCapitalCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Main application class for the tax calculator.
 */
public class CalculatorApp {

    /**
     * Main method for the tax calculator application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        IRegrasGanhoCapitalAcoes regras = new RegrasGanhoCapitalAcoesImpl();
        IImpostoGanhoCapitalCalculator calculator = ImpostoGanhoCapitalCalculatorImpl.of(regras);

        List<String> impostosToJson = new ArrayList<>();

        try(Scanner scanner = new Scanner(System.in)){

            while (scanner.hasNextLine()){

                String operationsJson = scanner.nextLine();

                if (operationsJson.isEmpty()) {
                    break;
                }

                List<OperacaoInput> operacoes = jsonToList(operationsJson);
                List<ImpostoOutput> impostos = domainToOutput(calculator.calcularImposto(inputToDomain(operacoes)));
                impostosToJson.add(listToJson(impostos));
            }

            impostosToJson.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Falha no processamento! "+ e);
            System.exit(100);
        } finally {
            System.exit(0);
        }
    }

}