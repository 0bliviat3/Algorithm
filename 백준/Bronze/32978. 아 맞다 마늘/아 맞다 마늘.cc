#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

std::vector<std::string> split(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<std::string> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(buffer);
	}

	return result;
}

void solve() {

	int n;
	std::cin >> n;
	std::cin.ignore();

	std::string input;
	std::getline(std::cin, input);
	std::vector<std::string> default_ingredient = split(input, ' ');
	std::getline(std::cin, input);
	std::vector<std::string> now_ingredient = split(input, ' ');

	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j < n; j++) {
			if (default_ingredient[j] == now_ingredient[i]) {
				default_ingredient.erase(default_ingredient.begin() + j);
				break;
			}
		}
	}

	std::cout << default_ingredient[0];
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}