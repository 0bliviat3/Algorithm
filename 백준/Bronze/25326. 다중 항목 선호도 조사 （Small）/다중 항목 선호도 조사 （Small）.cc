#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>

std::vector <std::string> split(const std::string& str, char delimiter) {
	std::vector<std::string> tokens;
	std::string token;
	std::istringstream tokenStream(str);
	while (std::getline(tokenStream, token, delimiter)) {
		tokens.push_back(token);
	}
	return tokens;
}

void solve() {

	int n, m;
	std::cin >> n >> m;
	std::cin.ignore();

	std::vector<std::vector<std::string>> table;
	for (int i = 0; i < n; ++i) {
		std::string line;
		std::getline(std::cin, line);
		table.push_back(split(line, ' '));
	}

	while (m--) {
		std::string query;
		std::getline(std::cin, query);
		std::vector<std::string> query_parts = split(query, ' ');
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			bool flag = true;
			for (int k = 0; k < 3; k++) {
				if (table[i][k] == query_parts[k] || query_parts[k] == "-") {
					continue;
				}
				flag = false;
				break;
			}
			if (flag) {
				count++;
			}
		}

		std::cout << count << "\n";
	}
	
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}