class SymptomChecker:
    def __init__(self):
        self.symptoms = {
            "fever": False,
            "cough": False,
            "headache": False,
            "rash": False
        }

    def askSymptoms(self):
        print("\n\nPlease answer in yes or no")
        for symptom in self.symptoms:
            response = input(f"Do you have {symptom}? ").lower()
            if response == "yes":
                self.symptoms[symptom] = True

    def diagnose(self):
        if self.symptoms["fever"] and self.symptoms["cough"]:
            print("You may have Flu")
        elif self.symptoms["fever"] and self.symptoms["headache"]:
            print("You may have Meningitis")
        elif self.symptoms["fever"] and self.symptoms["rash"]:
            print("You may have Measles")
        elif self.symptoms["headache"] and self.symptoms["cough"]:
            print("You may have cold")
        else:
            print("Failed to detect the disease. Please consult a doctor")

if __name__ == "__main__":
    checker = SymptomChecker()
    checker.askSymptoms()
    checker.diagnose()
