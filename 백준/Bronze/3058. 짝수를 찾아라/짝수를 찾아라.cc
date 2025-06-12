#include <iostream>
#include <vector>
#include <sstream>
#include <climits>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;
	
	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

int main() {

	std::ios::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int n;
	std::cin >> n;
	std::cin.ignore();
	std::string ans;

	while (n--) {
		std::string input;
		std::getline(std::cin, input);
		std::vector<int> numbers = split_to_int(input, ' ');
		int sum = 0, min_even = INT_MAX;
		int size = numbers.size();
		for (int i = 0; i < size; i++) {
			if (numbers[i] % 2 != 0) {
				continue;
			}
			sum += numbers[i];
			if (min_even > numbers[i]) {
				min_even = numbers[i];
			}
		}
		ans.append(std::to_string(sum))
			.append(" ")
			.append(std::to_string(min_even))
			.append("\n");
	}
	std::cout << ans;
	return 0;
}