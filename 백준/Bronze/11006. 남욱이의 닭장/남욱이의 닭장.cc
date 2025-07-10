#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>

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
	std::cin >> n;
	std::cin.ignore();

	std::string ans;
	std::string line;
	std::vector<int> numbers;
	while (n--) {
		std::getline(std::cin, line);
		numbers = split_to_int(line, ' ');
		int u = (numbers[1] << 1) - numbers[0];
		int t = numbers[1] - u;
		ans.append(std::to_string(u))
			.append(" ")
			.append(std::to_string(t))
			.append("\n");
	}

	std::cout << ans << std::flush;
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}