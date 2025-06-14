#include <iostream>
#include <vector>
#include <sstream>

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
	std::string line;
	std::getline(std::cin, line);
	std::vector<int> dists = split_to_int(line, ' '); //p q
	std::getline(std::cin, line);
	std::vector<int> prices = split_to_int(line, ' '); // a, b

	if (dists[0] >= dists[1]) {
		std::cout << prices[0] * dists[1] << std::endl;
	} else {
		int total_cost = 0;
		int remaining_distance = dists[1] - dists[0];
		total_cost += prices[0] * dists[0];
		total_cost += prices[1] * remaining_distance;
		std::cout << total_cost << std::endl;
	}
}

int main() {
	solve();
	return 0;
}
