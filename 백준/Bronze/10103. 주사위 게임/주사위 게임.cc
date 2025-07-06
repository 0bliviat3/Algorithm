#include <iostream>
#include <vector>
#include <sstream>
#include <string>

std::vector<int> split_to_int(std::string str, char delimiter) {
	std::istringstream ss(str);
	std::string buffer;

	std::vector<int> result;

	while (std::getline(ss, buffer, delimiter)) {
		result.push_back(std::stoi(buffer));
	}

	return result;
}

void solve() {
	int n;
	int a = 100, b = 100;
	std::cin >> n;
	std::cin.ignore();


	while (n--) {
		std::string line;
		std::getline(std::cin, line);
		std::vector<int> scores = split_to_int(line, ' ');
		if (scores[0] > scores[1]) {
			b -= scores[0];
		} else if (scores[0] < scores[1]) {
			a -= scores[1];
		}
	}

	std::cout << a << "\n" << b << "\n";	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}